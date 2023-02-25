import request from '@/utils/request'
 
export function doOrder(data) {
    return request({
        url: 'order/doOrder',
        method: 'post',
        data
    });
}