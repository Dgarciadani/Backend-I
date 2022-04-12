window.addEventListener("load", () => {
  const profile_space = document.querySelector(".profile_data");
  const address_space = document.querySelector(".address_data");
  const appointment_space = document.querySelector(".appointments_data");
  const urlRoot = "http://localhost:8080/";
  const search = document.querySelector(".search");
  const findAllBtn = document.querySelector(".btn-findall");
  const allPatients_space = document.querySelector(".all-list");
  const newPatientBtn = document.querySelector(".btn-add");
  document.querySelector(".btn-dentists").addEventListener("click", () => {
    window.location.href = "dentist.html";
  });
  findAllBtn.addEventListener("click", () => {
    allPatients_space.innerHTML = "";
    getAllPatients();
  });

  search.addEventListener("submit", (e) => {
    e.preventDefault();
    const search_value = document.querySelector(".search_value").value;

    if (search_value != "") {
      console.log("reloco");
      console.log(search_value);
      getUserData(search_value);
    } else {
      alert("Please enter a valid id/name");
    }
  });

  newPatientBtn.addEventListener("click", () => {
    renderNewPatientForm();
    // Get the patient data
  });
  const renderNewPatientForm = () => {
    profile_space.innerHTML = `
    <img src="./src/perri.jpeg" alt="patient">
    <div class="user">
    <h3> <input type="text" name="name" placeholder="name"> <input type="text" name="lastName" placeholder="lastName"></h3>
    <p> <input type="text" name="dni" placeholder="dni" ></p>
    <div class="editButtons">
    <button class="save_new">Save New</button>
    <button class="save_cancel" id="X"> X </button>
    </div>
    </div>`;
    address_space.innerHTML = `
    <h3>Address:</h3>
  <p><i>Street: </i><input type="text" name="street" placeholder="street" </p>
    <p><i>Number: </i><input type="text" name="door" placeholder="Number" </p>
  <p><i>City: </i><input type="text" name="city" placeholder="city" </p>
  <p><i>State: </i><input type="text" name="state" placeholder= "state"</p>`;
    appointment_space.innerHTML = `
  <h3>Appointments</h3>`;
    document.querySelector(".save_new").addEventListener("click", () => {
      let newUser = {
        name: document.querySelector("input[name=name]").value,
        lastName: document.querySelector("input[name=lastName]").value,
        dni: Number(document.querySelector("input[name=dni]").value),
        address: {
          street: document.querySelector("input[name=street]").value,
          door: Number(document.querySelector("input[name=door]").value),
          city: document.querySelector("input[name=city]").value,
          state: document.querySelector("input[name=state]").value,
        },
        dateInit: new Date(),
      };
      console.log(newUser);
      postNewPatient(newUser);
    });
  };
  const renderUserData = (user) => {
    profile_space.innerHTML = `
    <img src="./src/perri.jpeg" alt="patient">
    <div class="user">
    <h3> ${user.name} ${user.lastName} </h3>
    <p> ${user.dni}</p>
    <button class="edit_profile">Edit Profile</button>
    </div>`;

    const edit_profile = document.querySelector(".edit_profile");
    edit_profile.addEventListener("click", () => {
      renderEditUser();
    });
  };
  const renderEditUser = () => {
    let usertemp = JSON.parse(sessionStorage.getItem("user"));
    profile_space.innerHTML = `
    <img src="./src/perri.jpeg" alt="patient">
    <div class="user">
    <h3> <input type="text" name="name" value=${usertemp.name}> <input type="text" name="lastName" value=${usertemp.lastName}></h3>
    <p> <input type="text" name="dni" value=${usertemp.dni} ></p>
    <div class="editButtons">
    <button class="save_profile">Save Changes</button>
    <button class="save_cancel" id="X"> X </button>
    </div>
    </div>`;
    address_space.innerHTML = `
    <h3>Address:</h3>
  <p><i>Street: </i><input type="text" name="street" value=${usertemp.address.street} </p>
    <p><i>Number: </i><input type="text" name="door" value=${usertemp.address.door} </p>
  <p><i>City: </i><input type="text" name="city" value=${usertemp.address.city} </p>
  <p><i>State: </i><input type="text" name="state" value=${usertemp.address.state} </p>`;

    document.querySelector("button.save_profile").addEventListener("click", () => {
      let newData = {
        patient_id: usertemp.patient_id,
        name: document.querySelector("[name=name]").value,
        lastName: document.querySelector("[name=lastName]").value,
        dni: Number(document.querySelector("[name=dni]").value),
        address: {
          street: document.querySelector("[name=street]").value,
          door: Number(document.querySelector("[name=door]").value),
          city: document.querySelector("[name=city]").value,
          state: document.querySelector("[name=state]").value,
        },
        dateInit: usertemp.dateInit,
      };
      console.log(newData);
      allPatients_space.innerHTML = "";
      updateUser(usertemp.patient_id, newData);
    });
    document.querySelector("button.save_cancel").addEventListener("click", () => {
      getUserData(usertemp.patient_id);
    });
  };
  const renderAddressData = (user) => {
    address_space.innerHTML = `
    <h3>Address:</h3>
  <p><i>Street: </i>${user.address.street}</p>
    <p><i>Number: </i>${user.address.door}</p>
  <p><i>City: </i>${user.address.city}</p>
  <p><i>State: </i>${user.address.state}</p>`;
  };

  const renderAppointments = (appointments) => {
    appointment_space.innerHTML = `
  <h3>Appointments</h3>
  <lu class= "appo_list"> </lu>`;

    appointments.forEach((appointment) => {
      const appo_list = document.querySelector(".appo_list");
      appo_list.innerHTML += `
    <li> ${new Date(appointment.date).toLocaleDateString()} - ${
        new Date(appointment.date).getHours() +
        ":" +
        new Date(appointment.date).getMinutes()
      } Dentist: ${appointment.dentist.name}
    </li>`;
    });
  };
  const renderAllPatients = (patients) => {
    patients.forEach((patient) => {
      allPatients_space.innerHTML += `
    <li><button class="patient-btn" id=${patient.patient_id}>${patient.name} ${patient.lastName} -- DNI: ${patient.dni}</button></li>`;
    });
    document.querySelectorAll(".patient-btn").forEach((patient) => {
      patient.addEventListener("click", (e) => {
        getUserData(e.target.id);
      });
    });
  };

  const getUserData = (id) => {
    let settings = {
      method: "GET",
      headers: {
        "Content-Type": "application/json; charset=UTF-8",
      },
    };
    fetch(urlRoot + "patient/id=" + id, settings)
      .then((response) => {
        if (response.ok) {
          return response.json();
        }
        throw new Error(response.statusText);
      })
      .then((user) => {
        sessionStorage.clear();
        sessionStorage.setItem("user", JSON.stringify(user));
        console.log(user);
        renderUserData(JSON.parse(sessionStorage.getItem("user")));
        renderAddressData(JSON.parse(sessionStorage.getItem("user")));
        getAppointment(id);
        console.log(sessionStorage.getItem("user"));
      });
  };

  const getAppointment = (id) => {
    let settings = {
      method: "GET",
      headers: {
        "Content-Type": "application/json; charset=UTF-8",
      },
    };
    fetch(urlRoot + "appointment/patient=" + id, settings)
      .then((response) => {
        if (response.ok) {
          return response.json();
        }
        throw new Error(response.statusText);
      })
      .then((appointments) => {
        console.log(appointments);
        renderAppointments(appointments);
      });
  };

  const getAllPatients = () => {
    let settings = {
      method: "GET",
      headers: {
        "Content-Type": "application/json; charset=UTF-8",
      },
    };
    fetch(urlRoot + "patient/all", settings)
      .then((response) => {
        if (response.ok) {
          return response.json();
        }
        throw new Error(response.statusText);
      })
      .then((patients) => {
        console.log(patients);
        renderAllPatients(patients);
      });
  };

  const updateUser = (id, newData) => {
    let settings = {
      method: "PUT",
      headers: {
        "Content-Type": "application/json; charset=UTF-8",
      },
      body: JSON.stringify(newData),
    };
    fetch(urlRoot + "patient/id=" + id, settings)
      .then((response) => {
        if (response.ok) {
          return response.json();
        }
        throw new Error(response.statusText);
      })
      .then((user) => {
        sessionStorage.clear();
        sessionStorage.setItem("user", JSON.stringify(user));
        console.log(user);
        renderUserData(JSON.parse(sessionStorage.getItem("user")));
        renderAddressData(JSON.parse(sessionStorage.getItem("user")));
        getAppointment(user.patient_id);
        console.log(sessionStorage.getItem("user"));
      });
  };
const postNewPatient = (newData) => {
  let settings = {
    method: "POST",
    headers: {
      "Content-Type": "application/json; charset=UTF-8",
    },
    body: JSON.stringify(newData),
  };
  fetch(urlRoot + "patient/add", settings)
    .then((response) => {
      if (response.ok) {
        return response.json();
      }
      throw new Error(response.statusText);
    })
    .then((user) => {
      sessionStorage.clear();
      sessionStorage.setItem("user", JSON.stringify(user));
      console.log(user);
      renderUserData(JSON.parse(sessionStorage.getItem("user")));
      renderAddressData(JSON.parse(sessionStorage.getItem("user")));
      getAppointment(user.patient_id);
      console.log(sessionStorage.getItem("user"));
    });
}

});
