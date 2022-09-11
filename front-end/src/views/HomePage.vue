<template>
    <div>
        Username: <input type="text" v-model="username">
        <br>
        Password: <input type="text" v-model="password">
        <br>
        <button @click="login">Login</button>
        <div v-if="getUserInfor">
            Username: {{getUserInfor.username}}
            <br>
            Password: {{getUserInfor.password}}
            <br>
            dob: {{getUserInfor.dob}}
            <br>
            address: {{getUserInfor.address}}
            <br>
        </div>
        <br>
        <br>
        Username: <input type="text" v-model="username_re">
        <br>
        Password: <input type="text" v-model="password_re">
        <br>
        Dob: <input type="date" v-model="dob_re">
        <br>
        address: <input type="text" v-model="address_re">
        <br>
        <button @click="register">Register</button>
        <br> {{getRegisterMessage}}
        <br>
        <br>
        Username: <input type="text" v-model="username_up">
        <br>
        Password: <input type="text" v-model="password_up">
        <br>
        Dob: <input type="date" v-model="dob_up">
        <br>
        address: <input type="text" v-model="address_up">
        <br>
        <button @click="update">Update</button>
        <br>
        <br>
        Username: <input type="text" v-model="username_de">
        <br>
        Password: <input type="text" v-model="password_de">
        <br>
        <button @click="deleteUser">Delete</button>
        <br> {{getDeleteMessage}}
    </div>
</template>

<script>
import {UserServices} from "../services/user.services"

export default {
    data(){
        return{
            username: "",
            password: "",
            user_infor: null,
            username_re: "",
            password_re: "",
            dob_re: "",
            address_re: "",
            register_message: "",
            username_up: "",
            password_up: "",
            dob_up: "",
            address_up: "",
            username_de: "",
            password_de: "",
            delete_message: ""
        }
    },
    computed: {
        getUserInfor(){
            return this.user_infor
        },
        getRegisterMessage(){
            return this.register_message
        },
        getDeleteMessage(){
            return this.delete_message
        }
    },
    methods: {
        async login(){
            try{
                this.user_infor = null
                let res = await UserServices.getUser(this.username, this.password)
                if("username" in res.data)
                    this.user_infor = res.data
            }catch(err){
                console.log(err)
            }
        },
        async register(){
            try{
                this.register_message = ""
                let res = await UserServices.registerUser(this.username_re, this.password_re, this.dob_re, this.address_re)
                this.register_message = "register " + res.data
            }catch(err){
                console.log(err)
            }
        },
        async update(){
            try{
                let res = await UserServices.updateUser(this.username_up, this.password_up, this.dob_up, this.address_up)
                console.log(res.data)
            }catch(err){
                console.log(err)
            }
        },
        async deleteUser(){
            try{
                this.delete_message = ""
                let res = await UserServices.deleteUser(this.username_de, this.password_de)
                this.delete_message = "delete " + res.data
            }catch(err){
                console.log(err)
            }
        }
    }
};
</script>

<style>
</style>
