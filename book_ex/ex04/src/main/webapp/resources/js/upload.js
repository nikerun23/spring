function checkImageType(fileName) {
	var pattern = /jpg|gif|png|jpeg/i; // i 는 대소문자 구분없음
	return fileName.match(pattern);
}

function getFileInfo(fullName) {
	var fileName, imgsrc, getLink; // Template 변수
	var fileLink;
	
	if(checkImageType(fullName)) {
		imgsrc = "/displayFile?fileName=" + fullName; // 썸네일이미지
		fileLink = fullName.substr(14);
		
		var front = fullName.substr(0, 12); // /2017/12/25/
		var end = fullName.substr(14); // 이미지파일명
		
		getLink = "/displayFile?fileName=" + front + end;
		
	} else {
		imgsrc = "/resources/dist/img/file.png";
		fileLink = fullName.substr(12); // 일반파일명
		getLink = "/displayFile?fileName=" + fullName; // 일반파일
	}
	fileName = fileLink.substr(fileLink.indexOf("_")+1);
	
	return  {fileName:fileName, imgsrc:imgsrc, getLink:getLink, fullName:fullName};
	
}