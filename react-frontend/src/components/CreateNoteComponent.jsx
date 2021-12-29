import React, {useState, useEffect } from "react";
import { useHistory } from "react-router-dom";
import NoteService from "../services/NoteService";

const CreateNoteComponent = (props) => {

    const history = useHistory();
    const [patientId, setPatientId] = useState(props.match.params.patientId)
    const [content, setContent] = useState('');
    const [today] = useState(new Date());

    const saveNote = () =>{
        var date = today.getFullYear() + "-" + today.getMonth() + "-" + today.getDate() + " "  + today.getHours() + ":" + today.getMinutes();

        var note = {patientId: patientId, noteDate: date, content: content};

        console.log(date);

        NoteService.createNote(note).then(res =>{
            history.push('/view-patient/' + patientId);
        })
    }

    const cancel = () => {
        history.push('/view-patient/' + patientId);
    }

    return (
        <div>
            <div className = "container">
                <div className = "row">
                    <div className = "card col-md-6 offset-md-3 offset-md-3">
                        <h3 className="text-center">New Note</h3>
                        <div className="card-body">
                            {/* <form action=""> */}
                                <div className = "form-group">
                                    <textarea type="textarea" rows={5} cols={5} placeholder = "Note text" name = "note" className="form-control"
                                        value={content} onChange={e=> setContent(e.target.value)}/>
                                </div>
                                <button className="btn btn-success form_btn" onClick={()=> saveNote()}>Save</button>
                                <button className="btn btn-danger form_btn" onClick={()=>cancel()} style={{marginLeft: "10px"}}>Cancel</button>
                            {/* </form> */}
                        </div>
                    </div>

                </div>

            </div>
        </div>
    )
}

export default CreateNoteComponent
