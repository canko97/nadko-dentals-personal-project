import { ThreeSixty } from '@material-ui/icons';
import React, { Component } from 'react';
import PatientService from '../services/PatientService';
import ListNotesComponent from './ListNotesComponent';

class ViewPatientComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            id: this.props.match.params.id,
            firstName: '',
            lastName: '',
            email: '',
            phone: ''
        }
    }

    componentDidMount(){
      
        PatientService.getPatientById(this.state.id).then((res) => {
            let patient = res.data;
            this.setState({firstName: patient.firstName,
                lastName: patient.lastName,
                email: patient.email,
                phone: patient.phone   
            });
        })
    }

    render() {
        return (
            <div>
                <div className="card col-md-6 offset-md-3" style={{marginTop: "10px", borderRadius: "5px"}}>
                    {/* <h3 className="text-center">{this.state.firstName} {this.state.lastName}</h3> */}
                    <div className = "card-body" style ={{borderRadius: "10px"}}>
                        <div className="row">
                            <label htmlFor="">First Name: {this.state.firstName}</label>
                        </div>
                        <div className="row">
                            <label htmlFor="">Last Name: {this.state.lastName}</label>
                        </div>
                        <div className="row">
                            <label htmlFor="">Email: {this.state.email}</label>
                        </div>
                        <div className="row">
                            <label htmlFor="">Phone: {this.state.phone}</label>
                        </div>
                    </div>
                </div>
                <div className="card col-md-6 offset-md-3" style={{marginTop: "10px", borderRadius: "5px"}}>
                    <ListNotesComponent id = {this.state.id}/>
                </div>
            </div>
        );
    }
}

export default ViewPatientComponent;