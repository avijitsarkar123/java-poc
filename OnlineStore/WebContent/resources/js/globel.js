<!--
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
//-->

offMessage = ""

function boxOn(which, message) {
	if (document.all || document.getElementById) {
		which.Name = 'BorderOn'
		if (document.getElementById) {
			document.getElementById("Message").innerHTML = message
		}
		else {
			Message.innerHTML = message
		}
	}

}
function rollon(name) {
	document.images[name].src = "../resources/images/approach/" + name + "_down.gif"
}

function boxOff(which) {
	if (document.all || document.getElementById) {
		which.Name = 'BorderOff'
		if (document.getElementById) {
			document.getElementById("Message").innerHTML = offMessage
		}
		else {
			Message.innerHTML = offMessage
		}
	}
}
function rolloff(name) {
	document.images[name].src = "../resources/images/approach/" + name + "_up.gif"
}

function openurl()
{
	address = "height=400,width=590,topbar=no,status=no,toolbar=no,menubar=no,location=no,scrollbars=1";
	window.open("salesdivision.htm", "newwin", address)

}

function onclick() {
	if (document.all || document.getElementById) {
		which.Name = 'BorderOn'
		if (document.getElementById) {
			document.getElementById("Message").innerHTML = message
		}
		else {
			Message.innerHTML = message
		}
	}

}

function closewin()
{
	window.close();
}
//-->

offMesg = ""

function bOn(which, mesg) {
	if (document.all || document.getElementById) {
		which.Name = 'BorderOn'
		if (document.getElementById) {
			document.getElementById("Mesg").innerHTML = mesg
		}
		else {
			Mesg.innerHTML = mesg
		}
	}
}

function bOff(which) {
	if (document.all || document.getElementById) {
		which.Name = 'BorderOff'
		if (document.getElementById) {
			document.getElementById("Mesg").innerHTML = offMesg
		}
		else {
			Mesg.innerHTML = offMesg
		}
	}
}

//-->
// Script for Tooltip Message for Links

if (!document.layers && !document.all && !document.getElementById)
	event = "test"
function showtip(current, e, text) {

	if (document.all || document.getElementById) {
		thetitle = text.split('<br>')
		if (thetitle.length > 1) {
			thetitles = ''
			for (i = 0; i < thetitle.length; i++)
				thetitles += thetitle[i]
			current.title = thetitles
		}
		else
			current.title = text
	}

	else if (document.layers) {
		document.tooltip.document.write('<layer bgColor="white" style="border:1px solid black;font-size:12px;">' + text + '</layer>');
		document.tooltip.document.close();
		document.tooltip.left = e.pageX + 5;
		document.tooltip.top = e.pageY + 5;
		document.tooltip.visibility = "show";
	}
}
function hidetip() {
	if (document.layers)
		document.tooltip.visibility = "hidden"
}

//-->
