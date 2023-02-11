import axios from 'axios'

axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8';

const service = axios.create({
    //如果需要将前端应用部署到后端应用（Spring Boot fat jar）的static目录，则注释掉下面这行
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