import './App.css';


import { BrowserRouter, Route, Switch } from "react-router-dom";
import FooterComponent from './components/FooterComponent';
import ListPatientsComponent from './components/ListPatientsComponent';
import ListAppointmentsComponent from './components/ListAppointmentsComponent';
import CreatePatientComponent from './components/CreatePatientComponent';
import CreateAppointmentComponent from './components/CreateAppointmentComponent';
import ViewPatientComponent from './components/ViewPatientComponent';
import ProfileComponent from './components/ProfileComponent';
import PatientNameComponent from './components/PatientNameComponent';
import UpdatePatientComponent from './components/UpdatePatientComponent';
import UpdateAppointmentComponent from './components/UpdateAppointmentComponent';
import ListNotesComponent from './components/ListNotesComponent';
import CreateNoteComponent from './components/CreateNoteComponent';
import UpdateNoteComponent from './components/UpdateNoteComponent';
import HomePageComponent from './components/HomePageComponent';
import NavbarComponent from './components/NavbarComponent';
import RegisterComponent from './components/RegisterComponent';
import LoginComponent from './components/LoginComponent';



function App() {
  return (
    <>
    <div>
      <BrowserRouter>
        <NavbarComponent/>
        <div className="container">
          <Switch>
            <Route exact path={["/", "/home"]} exact component = {HomePageComponent}></Route>
            <Route exact path="/patients" component = {ListPatientsComponent}></Route>
            <Route exact path="/appointments" component = {ListAppointmentsComponent}></Route>
            <Route exact path="/register" component={RegisterComponent} />
            <Route exact path="/login" component={LoginComponent} />
            <Route exact path="/profile" component={ProfileComponent} />
            <Route path="/add-patient" component = {CreatePatientComponent}></Route>
            <Route path="/add-appointment" component = {CreateAppointmentComponent}></Route>
            <Route path="/add-note/:patientId" component = {CreateNoteComponent}></Route>
            <Route path="/view-patient/:id" component = {ViewPatientComponent}></Route>
            <Route path="/update-patient/:id" component = {UpdatePatientComponent}></Route>
            <Route path="/update-appointment/:id" component = {UpdateAppointmentComponent}></Route>
            <Route path="/update-note/:patientId/:id" component = {UpdateNoteComponent}></Route>
          </Switch>
        </div>
        <FooterComponent/>
      </BrowserRouter>
    </div>
    </>
  );
}
export default App;
