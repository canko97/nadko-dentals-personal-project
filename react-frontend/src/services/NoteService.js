import axios from 'axios';
import authHeader from "./AuthHeader";

const NOTES_API_BASE_URL = "http://localhost:8081/api/notes";

class NoteService{

    getNotes(patientId){
        return axios.get(NOTES_API_BASE_URL + '/' + patientId, { headers: authHeader() });
    }

    createNote(note){
        return axios.post(NOTES_API_BASE_URL, note, { headers: authHeader() });
    }

    getNoteById(noteId){
        return axios.get(NOTES_API_BASE_URL + "/single/" + noteId, { headers: authHeader() });
    }

    updateNote(note, noteId){
        return axios.put(NOTES_API_BASE_URL + "/single/" + noteId, note, { headers: authHeader() });
    }

    deleteNote(noteId){
        return axios.delete(NOTES_API_BASE_URL + "/single/" + noteId, { headers: authHeader() });
    }
    
}

export default new NoteService();