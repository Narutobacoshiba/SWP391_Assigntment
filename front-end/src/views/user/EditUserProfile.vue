<template>
    <div class="container">
     <div class="row flex-lg-nowrap">
      <div class="col">
        <div class="row">
          <div class="col mb-3">
            <div class="card">
              <div class="card-body">
                <div class="e-profile">
                  <div class="row">
                    <div class="col-12 col-sm-auto mb-3">
                      <div class="mx-auto" style="width: 140px;">
                        <div class="d-flex justify-content-center align-items-center rounded"
                          style="height: 140px; background-color: rgb(233, 236, 239);">
                          <span style="color: rgb(166, 168, 170); font: bold 8pt Arial;">140x140</span>
                        </div>
                      </div>
                    </div>
                    <div class="col d-flex flex-column flex-sm-row justify-content-between mb-3">
                      <div class="text-center text-sm-left mb-2 mb-sm-0">
                        <h4 class="pt-sm-2 pb-1 mb-0 text-nowrap">{{userName}}</h4>
                        <p class="mb-0">{{userEmail}}</p>

                        <div class="mt-2">
                          <button class="btn btn-primary" type="button">
                            <i class="fa fa-fw fa-camera"></i>
                            <span>Change Photo</span>
                          </button>
                        </div>
                      </div>
                      <div class="text-center text-sm-right">
                        <span class="badge badge-secondary" style="color: black;">{{userRole}}</span>
                        <div class="text-muted"><small>Joined 09 Dec 2017</small></div>
                      </div>
                    </div>
                  </div>
                  <ul class="nav nav-tabs">
                    <li class="nav-item"><a href="" class="active nav-link">Settings</a></li>
                  </ul>
                  <div class="tab-content pt-3">
                    <div class="tab-pane active">
                      <form class="form" novalidate="">
                        <div class="row">
                          <div class="col">
                            <div class="row">
                              <div class="col">
                                <div class="form-group">
                                  <label>Full Name</label>
                                  <input class="form-control" type="text" name="name" placeholder="Pham Phu Son"
                                    v-model="userName">
                                </div>
                              </div>
                              <div class="col">
                                <div class="form-group">
                                  <label>Role</label>
                                  <select class="form-control" style="margin-right: 20px ;" v-model="userRole">
                                    <option>admin</option>
                                    <option>user</option>
                                    <option>staff</option>
                                  </select>

                                </div>
                              </div>
                            </div>
                            <div class="row">
                              <div class="col">
                                <div class="form-group">
                                  <label>Status</label>
                                  <input type="radio" id="html" name="" v-model="userStatus" value="0" style="margin-left: 20px ;">
                                   <label for="">Banned</label>
                                   &nbsp;
                                   <input type="radio" id="css" name="" v-model="userStatus" value="1">
                                   <label for="">Active</label>
                                </div>
                              </div>
                            </div>
                            <div class="row">
                              <div class="col">
                                <div class="form-group">
                                  <label>Email</label>
                                  <input class="form-control" type="text" v-model="userEmail" placeholder="user@example.com">
                                </div>
                              </div>
                            </div>

                          </div>
                        </div>
                        <div class="row" style="margin-top:20px;">
                          <div class="col d-flex justify-content-end">
                            <div class="btn btn-primary" @click="editUser()">Save Changes</div>
                          </div>
                        </div>
                      </form>

                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
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
            userId: "",
            userName: "",
            userRole: "",
            userEmail: "",
            userStatus: 1,
        }
    }, 
    mounted() {
        this.getUserById();
    },
    methods: {
        async getUserById() {
            let id = this.$route.query["id"]
            let res = await UserServices.getUserById(id)
            if("id" in res.data){
                this.userId = res.data["id"]
                this.userName = res.data["username"]
                this.userEmail = res.data["email"]
                this.userRole = res.data["role"]
                this.userStatus = res.data["status"]
            }
		},
		async unbanUser(id){
			let res = await UserServices.unbanUser(id)
			if(res.data == true){
				this.getListUser()
			}
		},
        async editUser(){
            let res = await UserServices.editUserProfile(this.userId, this.userName, this.userRole, this.userStatus, this.userEmail)
            if(res.data == true){
                this.$notify({
                    group: 'foo',
                    type: 'success ',
                    text: 'Update successful'
                });
            }else{
                this.$notify({
                    group: 'foo',
                    type: 'warn',
                    text: 'update failed'
                });
            }
        }
   }
})
</script>
