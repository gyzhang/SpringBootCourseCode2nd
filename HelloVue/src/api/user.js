import request from '@/utils/request'
 
export function getAllUsers() {
    return request({
        url: 'user/get/all',
        method: 'get'
    });
}