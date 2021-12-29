import axios from "axios";
import authHeader from "./AuthHeader";

const API_URL = "http://localhost:8081/api/test/";

const getPublicContent = () => {
  return axios.get(API_URL + "all");
};

const getUserBoard = () => {
  return axios.get(API_URL + "user", { headers: authHeader() });
};

const getAssistantBoard = () => {
  return axios.get(API_URL + "assistant", { headers: authHeader() });
};

const getDentistBoard = () => {
  return axios.get(API_URL + "dentist", { headers: authHeader() });
};

export default {
  getPublicContent,
  getUserBoard,
  getAssistantBoard,
  getDentistBoard,
};