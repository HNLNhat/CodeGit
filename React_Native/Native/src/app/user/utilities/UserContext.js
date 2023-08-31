import React, { useState, createContext } from "react";
import AxiosInstance from "../../axiosClient/AxiosInstance";
import AsyncStorage from '@react-native-async-storage/async-storage';


export const UserContext = createContext();

export const UserProvider = (props) => {
  const { children } = props;
  const [isLoggedIn, setIsLogged] = useState(false);
  const login = async (email, password) => {
    try {
        const response = await AxiosInstance().post('/auth/login', {
          email: email,
          password: password,
        });
       const token = response.data.token;
        await AsyncStorage.setItem('token', token);//Lưu lại token
        setIsLogged(true); //Chuyển trạng thái login
        return true;
      }catch(error){
        console.log('login error:', error);
      }
      return false;
    }

  const register = async (email, password) => {
    try {
      await AxiosInstance().post('/users/register', {
        email: email,
        password: password,
      });
      return true;
    } catch (error) {
      console.log('register error:', error);
    }
    return false;
  };
  return (
    <UserContext.Provider value={{ isLoggedIn, setIsLogged, login, register }}>
      {children}
    </UserContext.Provider>
  );
};
