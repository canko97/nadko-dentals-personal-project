import React, { useRef, useCallback, useState, useEffect } from "react";
import { useHistory } from "react-router-dom";
import PatientService from "../services/PatientService";
import AuthService from '../services/AuthService'


const CreatePatientFunctionalComponent = () => {
    
    const user = AuthService.getCurrentUser();

    const history = useHistory();
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [phone, setPhone] = useState('');
    const [dentistId, setDentistId] = useState(user.id);
    
    // if(isAuthenticated){
    //     var str = user.email;
    // }

    const savePatient = (e) =>{
        var patient = {firstName: firstName, lastName: lastName, email: email, phone: phone, dentistId: dentistId};

        PatientService.createPatient(patient).then(res =>{
            history.push('/patients');
        })
    }

    const cancel = () => {
        history.push('/patients');
    }

    return (
        <div>
            <div>
                <div className = "container">
                    <div className = "row">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Add Patient</h3>
                            <div className="card-body">
                                {/* <form action=""> */}
                                    <div className = "form-group">
                                        <label htmlFor="">First Name</label>
                                        <input type="text" placeholder = "First Name" name = "firstName" className="form-control"
                                            value={firstName} onChange={e=> setFirstName(e.target.value)}/>
                                    </div>
                                    <div className = "form-group">
                                        <label htmlFor="">Last Name</label>
                                        <input type="text" placeholder = "Last Name" name = "lastName" className="form-control"
                                            value={lastName} onChange={e=> setLastName(e.target.value)}/>
                                    </div>
                                    <div className = "form-group">
                                        <label htmlFor="">Email</label>
                                        <input type="text" placeholder = "Email" name = "email" className="form-control"
                                            value={email} onChange={e=> setEmail(e.target.value)}/>
                                    </div>
                                    <div className = "form-group">
                                        <label htmlFor="">Phone</label>
                                        <input type="text" placeholder = "Phone" name = "phone" className="form-control"
                                            value={phone} onChange={e=> setPhone(e.target.value)}/>
                                    </div>

                                    <button className="btn btn-success form_btn" onClick={()=> savePatient()}>Save</button>
                                    <button className="btn btn-danger form_btn" onClick={()=>cancel()} style={{marginLeft: "10px"}}>Cancel</button>
                                {/* </form> */}
                            </div>
                        </div>

                    </div>

                </div>
            </div>
        </div>
    )
}

export default CreatePatientFunctionalComponent
