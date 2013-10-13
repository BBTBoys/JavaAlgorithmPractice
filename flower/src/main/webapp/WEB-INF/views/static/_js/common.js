var JavaProgramming = JavaProgramming || {};

(function ($Fn) {
	$Fn.SortAlgorithm = (function () {
		var _selectValueForSimpleSort = function (elem) {
			var container = $("#formContainer");
			var value = $(elem).val();
			if (container) {
				if (elem.checked) {
					$(container).append("<input type='hidden' class='"+value+"' name='values' value='"+value+"'>");
					$(container).find("fieldset").append("<div class='"+value+"'>"+value+"</div>");
				} else {
					$(container).find("."+value+"").remove();
				}
			}
		};
		
		return {
			selectValueForSimpleSort : _selectValueForSimpleSort
		};
	})();
})(JavaProgramming);