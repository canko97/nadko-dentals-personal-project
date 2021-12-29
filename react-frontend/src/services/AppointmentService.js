import axios from 'axios';
import authHeader from "./AuthHeader";

const APPOINTMENT_API_BASE_URL = "http://localhost:8081/api/appointments";

class AppointmentService{

    getAppointments(){
        return axios.get(APPOINTMENT_API_BASE_URL, { headers: authHeader() });
    }

    getDentistAppointments(dentistId){
        return axios.get(APPOINTMENT_API_BASE_URL + "/" + dentistId, { headers: authHeader() });
    }

    createAppointment(appointment){
        return axios.post(APPOINTMENT_API_BASE_URL, appointment, { headers: authHeader() });
    }

    getAppointmentById(appointmentId){
        return axios.get(APPOINTMENT_API_BASE_URL + "/single/" + appointmentId, { headers: authHeader() });
    }

    updateAppointment(appointment, appointmentId){
        return axios.put(APPOINTMENT_API_BASE_URL + "/single/" + appointmentId, appointment, { headers: authHeader() });
    }

    deleteAppointment(appointmentId){
        return axios.delete(APPOINTMENT_API_BASE_URL + "/single/" + appointmentId, { headers: authHeader() });
    }
    
}

export default new AppointmentService();