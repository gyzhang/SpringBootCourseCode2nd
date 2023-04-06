import axios from 'axios'

axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8';

const service = axios.create({
    baseURL: import.meta.env.VITE_BASE_API,
    timeout: 10000
});

service.interceptors.request.use(
    config => {
        return config;
    },
    error => {
        console.log(error);
        return Promise.reject(error);
    }
);

service.interceptors.response.use(
    response => {
        return response.data;
    },
    error => {
        console.log(error);
        return Promise.reject(error);
    }
);
 
export default service;