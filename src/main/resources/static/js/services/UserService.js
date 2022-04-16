import User from '../models/user.js';
import * as requestService from '../services/request-service.js';


export async function findAll() {
    const url = `http://localhost:8080/users`;
    const result = await requestService.getJson(url);

    return result;

}