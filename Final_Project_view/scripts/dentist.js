window.addEventListener("load", () => {
    const profile_space = document.querySelector(".profile_data");
    const appointment_space = document.querySelector(".appointments_data");
    const urlRoot = "http://localhost:8080/";
    const search = document.querySelector(".search");
    document.querySelector(".btn-patients").addEventListener("click", () => {
      window.location.href = "patient.html";
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
    // Get the patient data
  
    const renderUserData = (dentist) => {
      profile_space.innerHTML = `
      <img src="./src/dentist.png" alt="dentist">
      <div class="user">
      <h3> ${dentist.name} ${dentist.lastName}</h3>
      <p> register: ${dentist.register}</p>
      <button class="edit_profile">Edit Profile</button>
      </div>`;
    };

    const renderAppointments = (appointments) => {
      appointment_space.innerHTML = `
    <h3>Appointments</h3>
    <lu class= "appo_list"> </lu>`;
  
      appointments.forEach((appointment) => {
        const appo_list = document.querySelector(".appo_list");
        appo_list.innerHTML += `
      <li> ${new Date(appointment.date).toLocaleDateString()} -- ${
          new Date(appointment.date).getHours() +
          ":" +
          new Date(appointment.date).getMinutes()
        } Patient: ${appointment.patient.name}
      </li>`;
      });
    };
  
    const getUserData = (id) => {
      let settings = {
        method: "GET",
        headers: {
          "Content-Type": "application/json; charset=UTF-8",
        },
      };
      fetch(urlRoot + "dentist/id=" + id, settings)
        .then((response) => {
          if (response.ok) {
            return response.json();
          }
          throw new Error(response.statusText);
        })
        .then((user) => {
          renderUserData(user);
          getAppointment(id);
        });
    };
  
    const getAppointment = (id) => {
      let settings = {
        method: "GET",
        headers: {
          "Content-Type": "application/json; charset=UTF-8",
        },
      };
      fetch(urlRoot + "appointment/dentist=" + id, settings)
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









})