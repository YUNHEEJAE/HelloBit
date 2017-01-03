<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#video {
    border: 1px solid black;
    box-shadow: 2px 2px 3px black;
    width:640px;
    height:480px;
}

img{
    border: 1px solid black;
    box-shadow: 2px 2px 3px black;
    width:300px;
    height:240px;
    margin-right: 300px;
}
/* #photoTwo{
    border: 1px solid black;
    box-shadow: 2px 2px 3px black;
    width:300px;
    height:240px;
}


#photoThree{
    border: 1px solid black;
    box-shadow: 2px 2px 3px black;
    width:300px;
    height:240px;
} */

#canvas {
    display:none;
}

.camera {
    width: 340px;
    display:inline-block;
}

.output {
    width: 340px;
    display:inline-block;
   	float:left;
}

#startbutton {
    display:block;
    position:relative;
    margin-left:300px;
    margin-right:auto;
    bottom:32px;
    background-color: rgba(0, 150, 0, 0.5);
    border: 1px solid rgba(255, 255, 255, 0.7);
    box-shadow: 0px 0px 1px 2px rgba(0, 0, 0, 0.2);
    font-size: 14px;
    font-family: "Lucida Grande", "Arial", sans-serif;
    color: rgba(255, 255, 255, 1.0);
}

.contentarea {
    font-size: 16px;
    font-family: "Lucida Grande", "Arial", sans-serif;
    /* width: 760px; */
}

</style>
</head>
<body>
<div class="content-wrapper" style="min-height: 976px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			Picture Register <small>This is student take picture Page</small>
		</h1>
		<ol class="breadcrumb">
			

		</ol>
		</section>
	<!-- Main content -->
		<section class="content">
		<hr />

			<!-- 	<form method="post" id="inputForm"> -->
				<!-- Text input-->
 <div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">Input Stundent </h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
              <div class="box-body">
                <div class="form-group">
					<div class="contentarea">
          				<div class="camera">
        					<video id="video">Video stream not available.</video>
        					<button id="startbutton">Take photo</button>
    					</div>
    						<canvas id="canvas"></canvas>
 								<div class=row>
									<div class="col-md-4">
										<img id="photoOne">    
									</div>
									<div class="col-md-4">
										<img id="photoTwo"> 
									</div>
									<div class="col-md-4">
										<img id="photoThree"> 
									</div>
								</div>
						</div>
				</div>
			</div>
  </div>

              <!-- /.box-body -->
              
              <!-- /.box-footer -->
       
            <div class="box-footer">
                <button class="btn btn-default"> 메인 화면</button>
                
                <form action="pictureRegister" method="post" id="regImg">
                		<input type="hidden" name="sid" value="${sid}">
                		
                </form>
                <button class="btn btn-info pull-right" id="regBtn">등 록</button>
              </div>
              
          </div>
    
          <%@include file="footer.jsp"%>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://www.gstatic.com/firebasejs/3.6.2/firebase.js"></script>
<script>
	$(document).ready(function () {
        var config = {
            apiKey: "AIzaSyD8Qs39vkxQw8pdWiXlkcMug3PL1YJeS0Q",
            authDomain: "hhkbex.firebaseapp.com",
            databaseURL: "https://hhkbex.firebaseio.com",
            storageBucket: "hhkbex.appspot.com",
            messagingSenderId: "1050382686499"
        };
        firebase.initializeApp(config);

        // Get a reference to the storage service, which is used to create references in your storage bucket
        var storage = firebase.storage();
// Create a storage reference from our storage service
        var storageRef = storage.ref();
        var uid = "jk3a0123@gmail.com";
        var upw = "wjdwndud08";
        
        firebase.auth().signInWithEmailAndPassword(uid , upw).catch(function (error) {
            // Handle Errors here.
            console.log('error sign');
            var errorCode = error.code;
            var errorMessage = error.message;
        }); // end login

            var width = 640;    
            var height = 0;     
            var streaming = false;
            var timer =1 ;
            var video = null;
            var canvas = null;
            var photoOne = null;
            var photoTwo = null;
            var photoThree = null;
            var startbutton = null;
            var picture = null;

            function startup() {
                video = document.getElementById('video');
                canvas = document.getElementById('canvas');
                photoOne = document.getElementById('photoOne');
                photoTwo = document.getElementById('photoTwo');
                photoThree = document.getElementById('photoThree');
                startbutton = document.getElementById('startbutton');
                picture = document.getElementById('picture');

                navigator.getMedia = ( navigator.getUserMedia ||
                navigator.webkitGetUserMedia ||
                navigator.mozGetUserMedia ||
                navigator.msGetUserMedia);

                navigator.getMedia(
                    {
                        video: true,
                        audio: false
                    },
                    function(stream) {
                        if (navigator.mozGetUserMedia) {
                            video.mozSrcObject = stream;
                        } else {
                            var vendorURL = window.URL || window.webkitURL;
                            video.src = vendorURL.createObjectURL(stream);
                        }
                        video.play();
                    },
                    function(err) {
                        console.log("An error occured! " + err);
                    }
                );

                video.addEventListener('canplay', function(ev){
                    if (!streaming) {
                        height = (video.videoHeight) / (video.videoWidth/width);

                        // Firefox currently has a bug where the height can't be read from
                        // the video, so we will make assumptions if this happens.

                        if (isNaN(height)) {
                            height = width / (4/3);
                        }

                        video.setAttribute('width', width);
                        video.setAttribute('height', height);
                        canvas.setAttribute('width', width);
                        canvas.setAttribute('height', height);
                        streaming = true;
                    }
                }, false);

                startbutton.addEventListener('click', function(ev){

                    console.log(timer);
                    var imgdata = takepicture(timer);
                    timer +=1;
                    if(timer >= 4){
                        timer = 1;
                    }
                    console.log(timer);
	                	$("#regBtn").click(function (event) {
							$('#regImg').submit();
	    			
	    				});
                    ev.preventDefault();
                    
                }, false);

                clearphoto();
            }

            function clearphoto() {
                var context = canvas.getContext('2d');
                context.fillStyle = "#AAA";
                context.fillRect(0, 0, canvas.width, canvas.height);

                var data = canvas.toDataURL('image/png');

                photo.setAttribute('src', data);
            }
			
            function takepicture(timer) {
                var context = canvas.getContext('2d');
                if (width && height) {
                    canvas.width = width;
                    canvas.height = height;
                    context.drawImage(video, 0, 0, width, height);
                    
                    var data = canvas.toDataURL('image/png');
                    
                    	if(timer==1){
                    		photoOne.setAttribute('src' , data);
                    	}
                    	else if(timer==2){
                    		photoTwo.setAttribute('src' , data);
                    	}
                    	else if(timer==3){
                    		photoThree.setAttribute('src' , data);
                    	}
                    	
                    	var obj = {"data" : data};
                    	console.log(data);
                    	$.ajax({
        					url :"http://localhost:8080/web/file/registerImage",
        					type:"post",
        					data : obj,
        					dataType: "text",
        					success:function(data){
        						console.log(data);
        					$('#regImg').append("<input type='hidden' name='url' value='"+data+"'>");
		        				
        					}
        	
        				});

                    	uploadFile(data);
                    	
                    	return data;
                } else {
                    clearphoto();
                }
            }
            window.addEventListener('load', startup, false);
           
         // filebase login check
        firebase.auth().onAuthStateChanged(function (user) {

            var currentUser = firebase.auth().currentUser;

            if (currentUser) {
                console.log(currentUser.uid);
            } else {
                console.log("no user");
            }
        });

     		function uploadFile(data) {
        	    var xhr = new XMLHttpRequest();
                xhr.open('GET', data, true);
                xhr.responseType = 'blob';
                xhr.onload = function(e) {
                        if (this.status == 200) {
                            // get binary data as a response
                            var blob = this.response;
                            console.log(blob);
                            
                            // upload firebase img
                            var upload = storageRef.child("ex/" + uid+"_"+timer);
                            var uploadTask = upload.put(blob);
                            uploadTask.on('state_changed', function(snapshot){
                                // Observe state change events such as progress, pause, and resume
                                // See below for more detail
                            }, function(error) {
                                // Handle unsuccessful uploads
                            }, function() {
                                // Handle successful uploads on complete
                                // For instance, get the download URL: https://firebasestorage.googleapis.com/...
                                var downloadURL = uploadTask.snapshot.downloadURL;
                            });
                        }
                }; // onload end..
                xhr.send(); 
        	 
        } 
        
        
	
	});

</script>
</html>