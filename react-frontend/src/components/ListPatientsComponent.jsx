import React, { useRef, useCallback, useState, useEffect } from "react";
import { useHistory } from "react-router-dom";
import PatientService from "../services/PatientService";
import AuthService from '../services/AuthService'
import NotificationComponent from "./NotificationComponent";
import ConfirmDialogComponent from "./ConfirmDialogComponent";

function ListPatientsComponent (){

    const history = useHistory();
    const [patients, setPatients] = useState([]);
    const [searchValue, setSearchValue] = useState('');
    const [notify, setNotify] = useState({isOpen:false, message: '', type: ''});
    const user = AuthService.getCurrentUser();
    const [confirmDialog, setConfirmDialog] = useState({isOpen: false, title:'', subTitle:''});

    useEffect(() => {
        
        // var str = user.sub;
        // console.log(user.sub);
        // PatientService.getDentistPatients(str.replace("|", "-")).then((res) =>{
            
        // setPatients(res.data);
        // });
        getPatients();

    },[]);

    const getPatients = () =>{
        PatientService.getDentistPatients(user.id)
        .then(data => {
            let patients = data.data;
            setPatients(patients);
        }).catch(err => alert(err));
    };

    const addPatient = () =>{
        history.push('/add-patient');
    }

    const viewPatient = (id) => {
        history.push(`/view-patient/${id}`);
    }

    const editPatient = (id) => {
        history.push(`/update-patient/${id}`);
    }

    const deletePatient = (id) => {
        PatientService.deletePatient(id).then(res => {
            setPatients(patients.filter((patient) => patient.id != id))
        })
    }

    const onDelete= (id) => {
        setConfirmDialog({
            ...confirmDialog,
            isOpen:false
        })
        deletePatient(id);
        setNotify({
            isOpen: true,
            message: 'Deleted Successfully',
            type: 'error'
        })
    }

    if(user){
        return (
            <div>
                    <h2 className="text-center">{user.username}'s Patients</h2>
                    <div style={{display:"flex", justifyContent: "space-between"}}>
                        <div style={{display: "grid", gridTemplateColumns:"1fr 1fr 1fr", height:"38px"}} className="add-button" >
                            <button style={{marginLeft:"-15px", height:"38px", width: "120px"}} onClick={() => addPatient()} className="btn btn-primary" >Add Patient</button>
                            <input style={{marginLeft: "10px", height:"38px", border: "1px solid grey" , borderRadius:"5px"}} 
                                type="text" 
                                placeholder="Search..." 
                                onChange={(e)=>{
                                    setSearchValue(e.target.value);
                                }}
                            />
                        </div>
                        <div>
                            <NotificationComponent notify={notify} setNotify={setNotify}/>
                        </div>
                    </div>
                   
                    <div className="row">
                        <table className="table table-stripped table-bordered" style={{marginTop: "10px", borderRadius: "5px"}}>
                            
                            <thead>
                                <tr>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Email</th>
                                    <th>Phone</th>
                                    <th>Action</th>
    
                                </tr>
                            </thead>
    
                            <tbody>
                                {
                                    patients.filter((patient)=> {
                                        if(searchValue == "") {
                                            return patient;
                                        }else if(patient.firstName.toLowerCase().includes(searchValue.toLowerCase())||
                                                 patient.lastName.toLowerCase().includes(searchValue.toLowerCase())||
                                                 patient.email.toLowerCase().includes(searchValue.toLowerCase())||
                                                 patient.phone.toLowerCase().includes(searchValue.toLowerCase())) {
                                            return patient;
                                        }
                                    }).map(
                                        patient =>
                                        
                                        <tr className="patient_table_row" key = {patient.id}>
                                            <td>{patient.firstName}</td>
                                            <td>{patient.lastName}</td>
                                            <td>{patient.email}</td>
                                            <td>{patient.phone}</td>
                                            <td>
                                                <button onClick={() => editPatient(patient.id)} className="btn btn-info">Edit</button>
                                                <button 
                                                style={{marginLeft: "10px"}} 
                                                onClick={() => {
                                                    setConfirmDialog({
                                                        isOpen: true, 
                                                        title: 'Are you sure you want to delete this object?',
                                                        subTitle: "You can't undo this operation!",
                                                        onConfirm: ()=> {onDelete(patient.id)}
                                                    })
                                                }} 
                                                className="btn btn-danger">Delete</button>
                                                <button style={{marginLeft: "10px"}} onClick={() => viewPatient(patient.id)} className="btn btn-success">Info</button>
                                            </td>
                                        </tr>
                                        
                                        
                                    )
                                }
                                
                            </tbody>
                        
                        </table>
    
    
                    </div>
                    <ConfirmDialogComponent
                        confirmDialog={confirmDialog}
                        setConfirmDialog = {setConfirmDialog}
                    />
                    
                </div>
        )
    }else{
        return null;
    }
}

export default ListPatientsComponent
