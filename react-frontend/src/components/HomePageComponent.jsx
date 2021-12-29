import React, { useState, useEffect } from "react";
import AuthService from '../services/AuthService'

import UserService from "../services/UserService";

const HomePageComponent = () => {
  const [content, setContent] = useState("");
  const user = AuthService.getCurrentUser();

  // useEffect(() => {
  //   UserService.getPublicContent().then(
  //     (response) => {
  //       setContent(response.data);
  //     },
  //     (error) => {
  //       const _content =
  //         (error.response && error.response.data) ||
  //         error.message ||
  //         error.toString();

  //       setContent(_content);
  //     }
  //   );
  // }, []);

  if(!user){
    return (
      <div id="container" className="container">
        <header className="jumbotron">
          <h3>You should login!</h3>
        </header>
      </div>
    );
  }else{
    return (
      <div id="container" className="container">
        <header className="jumbotron">
          <h3>Welcome, {user.username}!</h3>
        </header>
      </div>
    );
  }
  
};

export default HomePageComponent;