<template>
<div class="container">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-xs-5">
                        <h2>User <b>Management</b></h2>
                    </div>
                    <div class="col-xs-7">
                        <div class="input-group">
                            <input v-model="searchText" type="search" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
                            <div @click="searchUser" class="btn btn-outline-primary">search</div>
                        </div>
                        <a href="#" class="btn btn-primary"><i class="material-icons">&#xE147;</i> <span>Add New User</span></a>
                        <a href="#" class="btn btn-primary"><i class="material-icons">&#xE24D;</i> <span>Export to Excel</span></a>						
                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>                      
                        <th>#</th>
                        <th>User</th>
						<th>Role</th>						
                        <th>status</th>
                        <th>Email</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(user,idx) in GetListUser" :key="user.id">
                        <td>{{idx}}</td>
                        <td><a href="" @click="showUserDetail(user.id)">{{user.username}}</a></td>
						<td>{{user.role}}</td>
                        <td>{{user.status == 0 ? "banned" : "active"}}</td>                       
                        <td>{{user.email}}</td>
                        <td>
							<i class="bi bi-stop-fill action-btn" @click="unbanUser(user.id)"></i>
							<i class="bi bi-stop-btn action-btn" @click="banUser(user.id)"></i>
                            <i class="bi bi-pencil-fill action-btn" @click="editUser(user.id)"></i>
                            <i class="bi bi-archive-fill action-btn" @click="deleteUser(user.id)"></i>
                        </td>
                    </tr>
                </tbody>
            </table>
            <div class="clearfix">
                <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
                <ul class="pagination">
                    <li class="page-item disabled"><a href="#">Previous</a></li>
                    <li class="page-item active"><a href="#" class="page-link">1</a></li>
                    <li class="page-item"><a href="#" class="page-link">2</a></li>
                    <li class="page-item"><a href="#" class="page-link">3</a></li>
                    <li class="page-item"><a href="#" class="page-link">4</a></li>
                    <li class="page-item"><a href="#" class="page-link">5</a></li>
                    <li class="page-item"><a href="#" class="page-link">Next</a></li>
                </ul>
            </div>
        </div>
    </div>        
</div>    
</template>

<script>
import {UserServices} from "../../services/user.services"

export default ({
    data() {
        return{
            userList: [],
            searchText: ""
        }
    }, 
    mounted() {
        this.getListUser();
    },
    computed: {
        GetListUser(){
            return this.userList
        }
    },
    methods: {
      async getListUser() {
         let res = await UserServices.listAllUser()
         this.userList = res.data
		},
		async unbanUser(id){
			let res = await UserServices.unbanUser(id)
			if(res.data == true){
				this.getListUser()
			}
		},
		async banUser(id){
			let res = await UserServices.banUser(id)
			if(res.data == true){
				this.getListUser()
			}
		},
        editUser(id){
            this.$router.push({name: "EditUserProfile", query: {"id": id} });
        },
        async deleteUser(id){
            if(confirm("do you want to delete this user?")){
                let res = await UserServices.deleteUserById(id)
                if(res.data == true){
                    this.getListUser()
                    this.$notify({
                        group: 'foo',
                        type: 'success ',
                        text: 'delete successful'
                    });
                }else{
                    this.$notify({
                        group: 'foo',
                        type: 'warn',
                        text: 'delete failed'
                    });
                }
            }
        },
        showUserDetail(id){
            this.$router.push({name: "UserProfile", query: {"id": id} });
        },
        async searchUser(){
            let res = await UserServices.searchUser(this.searchText)
            this.userList = res.data
        }
   }
})
</script>

<style>
.table-responsive {
        margin: 30px 0;
    }
	.table-wrapper {
        min-width: 1000px;
        background: #fff;
        padding: 20px 25px;
		border-radius: 3px;
        box-shadow: 0 1px 1px rgba(0,0,0,.05);
    }
	.table-title {
		padding-bottom: 15px;
		background: #299be4;
		color: #fff;
		padding: 16px 30px;
		margin: -20px -25px 10px;
		border-radius: 3px 3px 0 0;
    }
    .table-title h2 {
		margin: 5px 0 0;
		font-size: 24px;
	}
	.table-title .btn {
		color: #566787;
		float: right;
		font-size: 13px;
		background: #fff;
		border: none;
		min-width: 50px;
		border-radius: 2px;
		border: none;
		outline: none !important;
		margin-left: 10px;
	}
	.table-title .btn:hover, .table-title .btn:focus {
        color: #566787;
		background: #f2f2f2;
	}
	.table-title .btn i {
		float: left;
		font-size: 21px;
		margin-right: 5px;
	}
	.table-title .btn span {
		float: left;
		margin-top: 2px;
	}
    table.table tr th, table.table tr td {
        border-color: #e9e9e9;
		padding: 12px 15px;
		vertical-align: middle;
    }
	table.table tr th:first-child {
		width: 60px;
	}
	table.table tr th:last-child {
		width: 100px;
	}
	table.table-striped.table-hover tbody tr:hover {
		background: #f5f5f5;
	}
    table.table th i {
        font-size: 13px;
        margin: 0 5px;
        cursor: pointer;
    }	
    table.table td:last-child i {
		opacity: 0.9;
		font-size: 22px;
        margin: 0 5px;
    }
	table.table td a {
		font-weight: bold;
		color: #566787;
		display: inline-block;
		text-decoration: none;
	}
	table.table td a:hover {
		color: #2196F3;
	}
	table.table td a.settings {
        color: #2196F3;
    }
    table.table td a.delete {
        color: #F44336;
    }
    table.table td i {
        font-size: 19px;
    }
	table.table .avatar {
		border-radius: 50%;
		vertical-align: middle;
		margin-right: 10px;
	}
	.status {
		font-size: 30px;
		margin: 2px 2px 0 0;
		display: inline-block;
		vertical-align: middle;
		line-height: 10px;
	}
    .text-success {
        color: #10c469;
    }
    .text-info {
        color: #62c9e8;
    }
    .text-warning {
        color: #FFC107;
    }
    .text-danger {
        color: #ff5b5b;
    }
    .pagination {
        float: right;
        margin: 0 0 5px;
    }
    .pagination li a {
        border: none;
        font-size: 13px;
        min-width: 30px;
        min-height: 30px;
        color: #999;
        margin: 0 2px;
        line-height: 30px;
        border-radius: 2px !important;
        text-align: center;
        padding: 0 6px;
    }
    .pagination li a:hover {
        color: #666;
    }	
    .pagination li.active a, .pagination li.active a.page-link {
        background: #03A9F4;
    }
    .pagination li.active a:hover {        
        background: #0397d6;
    }
	.pagination li.disabled i {
        color: #ccc;
    }
    .pagination li i {
        font-size: 16px;
        padding-top: 6px
    }
    .hint-text {
        float: left;
        margin-top: 10px;
        font-size: 13px;
    }
.action-btn{
	cursor: pointer;
}

.input-group{
    width: 300px;
}
</style>