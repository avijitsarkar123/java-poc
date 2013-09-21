// rollover Colors
function ColorOut(cellName) { //v3.0
	cellName.Name = "subOut";

}


function ColorOver(cellName) { //v3.0
	cellName.Name = "subOver";

}

//Nav Links

function menuClick(URL) {

	document.location.href = URL;

}

//arr rolls

function MM_swapImgRestore() { //v3.0
	var i,x,a = document.MM_sr;
	for (i = 0; a && i < a.length && (x = a[i]) && x.oSrc; i++) x.src = x.oSrc;
}

function MM_preloadImages() { //v3.0
	var d = document;
	if (d.images) {
		if (!d.MM_p) d.MM_p = new Array();
		var i,j = d.MM_p.length,a = MM_preloadImages.arguments;
		for (i = 0; i < a.length; i++)
			if (a[i].indexOf("#") != 0) {
				d.MM_p[j] = new Image;
				d.MM_p[j++].src = a[i];
			}
	}
}

function MM_findObj(n, d) { //v3.0
	var p,i,x;
	if (!d) d = document;
	if ((p = n.indexOf("?")) > 0 && parent.frames.length) {
		d = parent.frames[n.substring(p + 1)].document;
		n = n.substring(0, p);
	}
	if (!(x = d[n]) && d.all) x = d.all[n];
	for (i = 0; !x && i < d.forms.length; i++) x = d.forms[i][n];
	for (i = 0; !x && d.layers && i < d.layers.length; i++) x = MM_findObj(n, d.layers[i].document);
	return x;
}

function MM_swapImage() { //v3.0
	var i,j = 0,x,a = MM_swapImage.arguments;
	document.MM_sr = new Array;
	for (i = 0; i < (a.length - 2); i += 3)
		if ((x = MM_findObj(a[i])) != null) {
			document.MM_sr[j++] = x;
			if (!x.oSrc) x.oSrc = x.src;
			x.src = a[i + 2];
		}
}


// new win

function open_window(url, h, w, bScroll, bTool, bResize) {
	var specs = "toolbar=" + bTool + ",location=0,directories=0,status=0,scrollbars=" + bScroll + ",resizable=" + bResize + ",width=" + w + ",height=" + h
	var winName = "newWin";
	mywin = window.open(url, winName, specs);
}


// quick roll

function rollon(name) {
	document.images[name].src = "../resources/images/" + name + "_down.gif"
}

function rolloff(name) {
	document.images[name].src = "../resources/images/" + name + "_up.gif"
}

// mytools mouseover

function showmenu(elmnt)
{
	document.all(elmnt).style.visibility = "visible"

	//worktools.src="../resources/images/work_tools_rollover.gif"
}


function hidemenu(elmnt)
{
	document.all(elmnt).style.visibility = "hidden"

	worktools.src = "../resources/images/worktools.gif"
}

// shortcuts opening/closing

cc = 0
function showshort()
{
	if (cc == 0)
	{
		cc = 1
		short.style.visibility = "visible"

		nms.src = "../resources/images/nms_down.gif"
	}
	else
	{
		cc = 0
		short.style.visibility = "hidden"

		nms.src = "../resources/images/nms_up.gif"
	}
}


function hideshort()
{
	if (cc == 1)
	{
		short.style.visibility = "hidden"

		nms.src = "../resources/images/nms_up.gif"
	}
}
