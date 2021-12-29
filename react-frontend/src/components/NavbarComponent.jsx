import React, { useRef, useCallback, useState, useEffect } from "react";
import AuthService from '../services/AuthService'
import { Link } from "react-router-dom";

const NavbarComponent = () => {

    // const [isAssistant, setIsAssistant] = useState(false);
    // const [isDentist, setIsDentist] = useState(false);
    const [currentUser, setCurrentUser] = useState(undefined);

    useEffect(() => {
        const user = AuthService.getCurrentUser();

        if (user) {
        setCurrentUser(user);
        // setIsAssistant(user.roles.includes("ROLE_ASSISTANT"));
        // setIsDentist(user.roles.includes("ROLE_DENTIST"));
        }
    }, []);

    const logOut = () => {
        AuthService.logout();
    };

    return (
        <nav className="navbar navbar-expand navbar-dark bg-dark">
          <Link to={"/"} className="navbar-brand">
            NadkoDentals
          </Link>
          <div className="navbar-nav mr-auto">
            <li className="nav-item">
              <Link to={"/home"} className="nav-link">
                Home
              </Link>
            </li>

            {currentUser &&(<li className="nav-item">
              <Link to={"/patients"} className="nav-link">
                Patients
              </Link>
            </li>
            )}

            {currentUser &&(<li className="nav-item">
              <Link to={"/appointments"} className="nav-link">
                Appointments
              </Link>
            </li>
            )}

            {/* {isAssistant && (
              <li className="nav-item">
                <Link to={"/assistant"} className="nav-link">
                  Assistant Board
                </Link>
              </li>
            )}

            {showAdminBoard && (
              <li className="nav-item">
                <Link to={"/admin"} className="nav-link">
                  Admin Board
                </Link>
              </li>
            )}

            {currentUser && (
              <li className="nav-item">
                <Link to={"/user"} className="nav-link">
                  User
                </Link>
              </li>
            )} */}
          </div>

          {currentUser ? (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <Link to={"/profile"} className="nav-link">
                  {currentUser.username}
                </Link>
              </li>
              <li className="nav-item">
                <a href="/login" className="nav-link" onClick={logOut}>
                  LogOut
                </a>
              </li>
            </div>
          ) : (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <Link to={"/login"} className="nav-link">
                  Login
                </Link>
              </li>

              <li className="nav-item">
                <Link to={"/register"} className="nav-link">
                  Sign Up
                </Link>
              </li>
            </div>
          )}
        </nav>
    )
}

export default NavbarComponent
