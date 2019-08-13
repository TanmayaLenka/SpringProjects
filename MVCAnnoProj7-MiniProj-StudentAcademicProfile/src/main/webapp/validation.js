	function Validate(frm){
		frm.flag.value="yes";
		var sname=document.getElementById("sname").value;
		var branch=document.getElementById("branch").value;
		var semester=document.getElementById("semester").value;
		var backlogs=document.getElementById("backlogs").value;
		if(sname==""||sname.length==0){
			document.getElementById("errsname").innerHTML="Student name required";
			return false;
		}else{
			document.getElementById("errsname").innerHTML="";
		}if(branch==""||branch.length==0){
			document.getElementById("errbranch").innerHTML="Branch name required";
			return false;
		}else{
			document.getElementById("errbranch").innerHTML="";
		}if(semester==0||semester<0){
			document.getElementById("errsemester").innerHTML="Semester must not be zero or negetive";
			return false;
		}else{
			document.getElementById("errsemester").innerHTML="";
		}
		if(backlogs<0){
			document.getElementById("errbacklogs").innerHTML="Please enter a positive value";
			return false;
		}else{
			document.getElementById("errbacklogs").innerHTML="";
		}
		return true;

	}