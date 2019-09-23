function formatDateFromChar(date) {
	date = date.substr(0, 4) + "-" + date.substr(3, 2) + "-"
			+ date.substr(5, 2);
	return date;
}