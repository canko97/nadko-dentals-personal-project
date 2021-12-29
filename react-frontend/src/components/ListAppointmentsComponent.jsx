import React, { useRef, useCallback, useState, useEffect } from "react";
import { useHistory } from "react-router-dom";
import AppointmentService from "../services/AppointmentService";
import AuthService from '../services/AuthService'
import PatientNameComponent from "./PatientNameComponent";

function ListAppointmentsComponent (){

    const user = AuthService.getCurrentUser();

    const history = useHistory();
    const [appointments, setAppointments] = useState([]);

    useEffect(() => {
        getAppointments();
    },[]);

    const getAppointments = () =>{
        AppointmentService.getDentistAppointments(user.id)
        .then(data => {
            let appointment = data.data;
            setAppointments(appointment);
        }).catch(err => alert(err));
    };

    const addAppointment = () =>{
        history.push('/add-appointment');
    }

    // const viewAppointment = (id) => {
    //     history.push(`view-appointment/${id}`);
    // }

    const editAppointment = (id) => {
        history.push(`/update-appointment/${id}`);
    }

    const deleteAppointment = (id) => {
        AppointmentService.deleteAppointment(id).then(res => {
            setAppointments(appointments.filter((appointment) => appointment.id != id))
        })
    }

    

    return (
        <div>
                <h2 className="text-center">Appointments</h2>
                <div className="add-button row">
                    <button onClick={() => addAppointment()} className="btn btn-primary" >Add Appointment</button>
                </div>
                <div className="row">
                    <table className="table table-stripped table-bordered" style={{marginTop: "10px", borderRadius: "5px"}}>
                        
                        <thead>
                            <tr>
                                <th>Patient Id</th>
                                <th>Date</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        
                        <tbody>
                            {
                                appointments.map(
                                    appointment =>
                                    
                                    <tr key = {appointment.id}>
                                        <PatientNameComponent id={appointment.patientId}/>
                                        <td>{appointment.appointmentDate}</td>
                                        <td>
                                            <button onClick={() => editAppointment(appointment.id)} className="btn btn-info">Update</button>
                                            <button style={{marginLeft: "10px"}} onClick={() => deleteAppointment(appointment.id)} className="btn btn-danger">Delete</button>
                                        </td>
                                    </tr>
                                )
                            }
                            
                        </tbody>
                    
                    </table>


                </div>
                
            </div>
    )

}

export default ListAppointmentsComponent
