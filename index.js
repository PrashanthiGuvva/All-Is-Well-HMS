const BASE_URL = "http://localhost:8080";

// ---------------- PATIENT REGISTER ----------------
async function registerPatient(e) {
    e.preventDefault();

    const patient = {
        name: document.getElementById("patientName").value,
        email: document.getElementById("patientEmail").value,
        password: document.getElementById("patientPassword").value,
        phone: document.getElementById("patientPhone").value,
        address: document.getElementById("patientAddress").value
    };

    try {
        const res = await fetch(`${BASE_URL}/auth/patient/register`, {
            method: "POST",
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(patient)
        });

        if (res.ok) {
            alert("Patient registered successfully!");
            document.getElementById("patientRegisterForm").reset();
        } else {
            const error = await res.text();
            alert("Registration failed: " + error);
        }
    } catch (err) {
        console.error(err);
        alert("Error connecting to server.");
    }
}

// ---------------- PATIENT LOGIN ----------------
async function loginPatient(e) {
    e.preventDefault();

    const body = {
        email: document.getElementById("patientLoginEmail").value,
        password: document.getElementById("patientLoginPassword").value
    };

    try {
        const res = await fetch(`${BASE_URL}/auth/patient/login`, {
            method: "POST",
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(body)
        });

        if (res.ok) {
            const data = await res.json();
            localStorage.setItem("userType", "patient");
            localStorage.setItem("userId", data.id);

            // Redirect to dashboard
            window.location.href = "dashboard.html";
        } else {
            alert("Invalid patient credentials");
        }
    } catch (err) {
        console.error(err);
        alert("Error connecting to server.");
    }
}

// ---------------- DOCTOR REGISTER ----------------
async function registerDoctor(e) {
    e.preventDefault();

    const doctor = {
        name: document.getElementById("doctorName").value,
        email: document.getElementById("doctorEmail").value,
        password: document.getElementById("doctorPassword").value,
        specialization: document.getElementById("doctorSpecialization").value
    };

    try {
        const res = await fetch(`${BASE_URL}/auth/doctor/register`, {
            method: "POST",
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(doctor)
        });

        if (res.ok) {
            alert("Doctor registered successfully!");
            document.getElementById("doctorRegisterForm").reset();
        } else {
            const error = await res.text();
            alert("Registration failed: " + error);
        }
    } catch (err) {
        console.error(err);
        alert("Error connecting to server.");
    }
}

// ---------------- DOCTOR LOGIN ----------------
async function loginDoctor(e) {
    e.preventDefault();

    const body = {
        email: document.getElementById("doctorLoginEmail").value,
        password: document.getElementById("doctorLoginPassword").value
    };

    try {
        const res = await fetch(`${BASE_URL}/auth/doctor/login`, {
            method: "POST",
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(body)
        });

        if (res.ok) {
            const data = await res.json();
            localStorage.setItem("userType", "doctor");
            localStorage.setItem("userId", data.id);

            // Redirect to dashboard
            window.location.href = "dashboard.html";
        } else {
            alert("Invalid doctor credentials");
        }
    } catch (err) {
        console.error(err);
        alert("Error connecting to server.");
    }
}

// ---------------- FORM EVENT LISTENERS ----------------
document.getElementById("patientRegisterForm").addEventListener("submit", registerPatient);
document.getElementById("patientLoginForm").addEventListener("submit", loginPatient);
document.getElementById("doctorRegisterForm").addEventListener("submit", registerDoctor);
document.getElementById("doctorLoginForm").addEventListener("submit", loginDoctor);
