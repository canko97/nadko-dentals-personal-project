import React, { useRef, useCallback, useState, useEffect } from 'react'
import PatientService from "../services/PatientService";
import { useHistory } from 'react-router'

const PatientNameComponent = ({id}) => {

    const [patientId, setPatientId] = useState(id);
    const [patientFirstName, setPatientFirstName] = useState("");
    const [patientLastName, setPatientLastName] = useState("");

    useEffect(() => {
            PatientService.getPatientById(patientId)
            .then(result => {
                var patient = result.data;
                setPatientFirstName(patient.firstName);
                setPatientLastName(patient.lastName)
            }).catch(err => alert(err));
    }, [])

    return (<td>{patientFirstName} {patientLastName}</td>)
}

export default PatientNameComponent
