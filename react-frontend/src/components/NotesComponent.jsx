import React, { useRef, useCallback, useState, useEffect } from "react";
import Spinner from 'react-bootstrap/Spinner'
import EditTwoToneIcon from '@material-ui/icons/EditTwoTone';
import DeleteTwoToneIcon from '@material-ui/icons/DeleteTwoTone';


const NotesComponent = ({notes, loading, deleteNote, editNote}) => {


    if(loading){
        return (<Spinner animation="border" role="status">
        <span className="sr-only">Loading...</span>
      </Spinner>)
    }

    return(
        <ul className="list-group mb-3">
            {notes.map(note=>
                <li key={note.id} className="list-group-item">
                    <div style={{backgroundColor: "#17a2b8", color:"white", minHeight:"30px", borderRadius: "5px 5px 0px 0px", paddingLeft:"10px", display:"flex", justifyContent: "space-between"}}>
                        <div style={{display: "flex", alignItems: "center", justifyContent: "center", marginRight: "10px"}}>
                            {note.noteDate} 
                        </div>
                        <div style={{display: "flex", justifyContent:"flex-end"}}>
                            <button style={{maxWidth:"30px", display:"flex", justifyContent: "center"}} onClick={() => editNote(note.id)} className="btn btn-info" >
                                <EditTwoToneIcon  
                                    style={{ color: "white", width: "20px", height: "20px"}} />
                            </button>
                            <button style={{maxWidth:"30px",display:"flex", justifyContent: "center"}} onClick={() => deleteNote(note.id)} className="btn btn-info" >
                                <DeleteTwoToneIcon  
                                    style={{ color: "white", width: "20px", height: "20px"}} />
                            </button>
                        </div>
                    </div>

                    <div style={{backgroundColor:"#D3D3D3", minHeight:"60px", borderRadius: "0px 0px 5px 5px", paddingLeft:"20px"}}>{note.content}</div>
                </li>
            )}
        </ul>
    )
}

export default NotesComponent
