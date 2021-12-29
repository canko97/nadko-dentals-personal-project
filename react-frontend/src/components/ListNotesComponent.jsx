import axios from "axios";
import React, { useRef, useCallback, useState, useEffect } from "react";
import { useHistory } from "react-router-dom";
import NoteService from "../services/NoteService";
import NotesComponent from "./NotesComponent";
import Pagination from "./Pagination";

const ListNotesComponent = ({id}) => {

    const history = useHistory();

    const [patientId] = useState(id);
    const [notes, setNotes] = useState([]);
    const [loading, setLoading] = useState(false);
    const [currentPage, setCurrentPage] = useState(1);
    const [notesPerPage] = useState(3);

    useEffect(() => {
        const getNotes = async () =>{
            setLoading(true);
            const res = await NoteService.getNotes(patientId);
            setNotes(res.data);
            setLoading(false);
            // NoteService.getNotes()
            // .then(data => {
            //     let notesData = data.data;
            //     setNotes(notesData);
            // }).catch(err => alert(err));
        };

        getNotes();
    }, [])

    const addNote = () =>{
        history.push('/add-note/' + patientId);
    }

    const deleteNote = (id) => {
        NoteService.deleteNote(id).then(res => {
            setNotes(notes.filter((note) => note.id != id))
        })
    }

    const editNote = (noteId) =>{
        history.push('/update-note/' + patientId + "/" + noteId)
    }

    const indexOfLastNote = currentPage*notesPerPage;
    const indexOfFirstNote = indexOfLastNote - notesPerPage;
    const currentNotes = notes.slice(indexOfFirstNote, indexOfLastNote);
    
    const paginate = (pageNumber) => setCurrentPage(pageNumber);

    return (
        <div>

            <h5 className="text-center mb-3">NOTES</h5>
            <div style={{marginLeft:"20px", marginBottom:"5px"}} className="row">
                <button onClick={() => addNote()} className="btn btn-info" >New</button>
            </div>
            
            <NotesComponent notes={currentNotes} loading={loading} deleteNote={deleteNote} editNote = {editNote}/>
            <Pagination notesPerPage={notesPerPage} totalNotes = {notes.length} paginate={paginate}/>
        </div>
        
    )
}

export default ListNotesComponent
