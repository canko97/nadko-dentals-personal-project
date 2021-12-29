import axios from 'axios';
import authHeader from "./AuthHeader";


const PATIENT_API_BASE_URL = "http://localhost:8081/api/patients";

class PatientService{

    getPatients(){
        return axios.get(PATIENT_API_BASE_URL, { headers: authHeader() });
    }

    createPatient(patient){
        return axios.post(PATIENT_API_BASE_URL, patient, { headers: authHeader() });
    }

    getDentistPatients(dentistId){
        return axios.get(PATIENT_API_BASE_URL + '/' + dentistId, { headers: authHeader() });
    }

    getPatientById(patientId){
        return axios.get(PATIENT_API_BASE_URL + '/single/' + patientId, { headers: authHeader() });
    }

    updatePatient(patient, patientId){
        return axios.put(PATIENT_API_BASE_URL + "/single/" + patientId, patient, { headers: authHeader() });
    }

    deletePatient(patientId){
        return axios.delete(PATIENT_API_BASE_URL + '/single/' + patientId, { headers: authHeader() });
    }
    
}

export default new PatientService();