import React, {useState, useEffect } from "react";
import { useHistory } from "react-router-dom";
import AppointmentService from "../services/AppointmentService";
import AuthService from '../services/AuthService'
import PatientService from "../services/PatientService";
import TextField from "@material-ui/core/TextField";

const CreateAppointmentComponent = (props) => {

    const user = AuthService.getCurrentUser();

    const history = useHistory();
    const [patients, setPatients] = useState([]); 
    const [patientId, setPatientId] = useState('');
    const [date, setDate] = useState('');

    useEffect(() => {
        getPatients();
    },[]);

    const getPatients = () =>{
        PatientService.getDentistPatients(user.id)
        .then(data => {
            let patients = data.data;
            setPatients(patients);
        }).catch(err => alert(err));
    };

    const saveAppointment = () =>{
        var appointment = {patientId: patientId, appointmentDate: date.split("T")[0] + " " + date.split("T")[1], dentistId: user.id};

        AppointmentService.createAppointment(appointment).then(res =>{
            history.push('/appointments');
        })
    }

    const cancel = () => {
        history.push('/appointments');
    }

    return (
        <div>
            <div className = "container">
                <div className = "row">
                    <div className = "card col-md-6 offset-md-3 offset-md-3">
                        <h3 className="text-center">Edit Patient</h3>
                        <div className="card-body">
                            {/* <form action=""> */}

                                <div className = "form-group">
                                    <label htmlFor="patient">Patient</label>
                                    <select name="patient" id="patient" className="form-control" onChange={e=> setPatientId(e.target.value)}>
                                        <option selected value=''> Select a patient...</option>
                                        {patients.map((patient)=>
                                            <option value={patient.id}>{patient.id}. {patient.firstName} {patient.lastName}</option>
                                        )}
                                    </select>
                                </div>

                                <div className="form-group">
                                    <label>Appointment Time:</label>
                                    <TextField
                                    id="appointmentDateTime"
                                    type="datetime-local"
                                    value={date}
                                    onChange={(e)=>setDate(e.target.value)}
                                    className={"form-control textbox"}
                                    InputLabelProps={{
                                        shrink: true,
                                    }}
                                    />
                                </div>

                                <button className="btn btn-success form_btn" onClick={()=> saveAppointment()}>Save</button>
                                <button className="btn btn-danger form_btn" onClick={()=>cancel()} style={{marginLeft: "10px"}}>Cancel</button>
                            {/* </form> */}
                        </div>
                    </div>

                </div>

            </div>
        </div>
    )
}

export default CreateAppointmentComponent
