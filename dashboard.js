const BASE_URL = "http://localhost:8080";

// ---------------- LOGIN CHECK ----------------
window.addEventListener("load", () => {
    const userType = localStorage.getItem("userType");
    const userId = localStorage.getItem("userId");

    if (!userType || !userId) {
        alert("Please login first!");
        localStorage.clear();
        window.location.href = "index.html";
    } else {
        initializeDashboard(userType, userId);
    }
});

// ---------------- INITIALIZE DASHBOARD ----------------
function initializeDashboard(userType, userId) {
    if (userType === "patient") {
        document.getElementById("patientAppointmentsDiv").style.display = "block";
        loadDoctorsDropdown();
        loadMyAppointments(userId);
        loadMyPayments(userId);
    } else if (userType === "doctor") {
        document.getElementById("patientAppointmentsDiv").style.display = "none";
        loadDoctorAppointments(userId);
        loadDoctorPatients(userId);
    }
}

// ---------------- LOGOUT ----------------
function logout(){
    localStorage.removeItem("userType");
    localStorage.removeItem("userId");
    window.location.href = "index.html";
}

// ---------------- SECTION NAVIGATION ----------------
function showSection(sectionId){
    document.querySelectorAll(".page-section").forEach(sec => sec.classList.add("hidden"));
    document.getElementById(sectionId).classList.remove("hidden");
}

// ---------------- PATIENT FUNCTIONS ----------------
async function loadDoctorsDropdown() {
    const res = await fetch(`${BASE_URL}/doctors`);
    const data = await res.json();
    const select = document.getElementById("doctorSelect");
    select.innerHTML = '<option value="">Select Doctor</option>';
    data.forEach(d => {
        const option = document.createElement("option");
        option.value = d.id;
        option.text = `${d.name} (${d.specialization})`;
        select.add(option);
    });
}

async function addAppointment(e){
    e.preventDefault();
    const appointment = {
        doctorId: document.getElementById("doctorSelect").value,
        patientId: localStorage.getItem("userId"),
        appointmentTime: document.getElementById("appointmentTime").value,
        status: document.getElementById("status").value
    };
    const res = await fetch(`${BASE_URL}/appointments`, {
        method: "POST",
        headers: {'Content-Type':'application/json'},
        body: JSON.stringify(appointment)
    });
    if(res.ok){
        alert("Appointment booked!");
        loadMyAppointments(localStorage.getItem("userId"));
        e.target.reset();
    }
}

async function loadMyAppointments(patientId){
    const res = await fetch(`${BASE_URL}/appointments/patient/${patientId}`);
    const data = await res.json();
    const list = document.getElementById("appointmentsList");
    list.innerHTML = "";
    data.forEach(a => list.innerHTML += `<li>Doctor ID:${a.doctorId} Time:${a.appointmentTime} Status:${a.status}</li>`);
}

async function addPayment(e){
    e.preventDefault();
    const payment = {
        patientId: localStorage.getItem("userId"),
        amount: document.getElementById("paymentAmount").value,
        method: document.getElementById("paymentMethod").value,
        note: document.getElementById("paymentNote").value,
        paidAt: new Date().toISOString()
    };
    const res = await fetch(`${BASE_URL}/payments`, {
        method: "POST",
        headers: {'Content-Type':'application/json'},
        body: JSON.stringify(payment)
    });
    if(res.ok){
        alert("Payment successful!");
        loadMyPayments(localStorage.getItem("userId"));
        e.target.reset();
    }
}

async function loadMyPayments(patientId){
    const res = await fetch(`${BASE_URL}/payments/patient/${patientId}`);
    const data = await res.json();
    const list = document.getElementById("paymentsList");
    list.innerHTML = "";
    data.forEach(p => list.innerHTML += `<li>₹${p.amount} - ${p.method} - ${p.note}</li>`);
}

// ---------------- DOCTOR FUNCTIONS ----------------
async function loadDoctorAppointments(doctorId){
    const res = await fetch(`${BASE_URL}/appointments/doctor/${doctorId}`);
    const data = await res.json();
    const list = document.getElementById("appointmentsList");
    list.innerHTML = "";
    data.forEach(a => list.innerHTML += `<li>Patient ID:${a.patientId} Time:${a.appointmentTime} Status:${a.status}</li>`);
}

async function loadDoctorPatients(doctorId){
    const res = await fetch(`${BASE_URL}/patients/doctor/${doctorId}`);
    const data = await res.json();
    const list = document.getElementById("paymentsList");
    list.innerHTML = "";
    data.forEach(p => list.innerHTML += `<li>${p.name} - ${p.phone} - ${p.email}</li>`);
}

// ---------------- SERVICES, RECEIPTS, INSURANCE ----------------
async function loadServices(){
    const res = await fetch(`${BASE_URL}/services`);
    const data = await res.json();
    const list = document.getElementById("servicesList");
    list.innerHTML = "";
    data.forEach(s => list.innerHTML += `<li>${s.name} - ₹${s.price} - ${s.description}</li>`);
}

async function loadReceipts(){
    const res = await fetch(`${BASE_URL}/receipts`);
    const data = await res.json();
    const list = document.getElementById("receiptsList");
    list.innerHTML = "";
    data.forEach(r => list.innerHTML += `<li>₹${r.amount} - ${r.content} - ${r.createdAt}</li>`);
}

async function loadInsurance(){
    const res = await fetch(`${BASE_URL}/insurance`);
    const data = await res.json();
    const list = document.getElementById("insuranceList");
    list.innerHTML = "";
    data.forEach(i => list.innerHTML += `<li>${i.providerName} - ${i.policyNumber} - ${i.coverageDetails}</li>`);
}
