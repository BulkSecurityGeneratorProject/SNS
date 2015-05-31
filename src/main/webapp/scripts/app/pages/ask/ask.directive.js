'use strict';

angular.module('solveandshareApp')

.directive('fileModel', [ '$parse', function($parse) {
	return {
		restrict : 'A',
		link : function(scope, element, attrs) {
			var model = $parse(attrs.fileModel);
			var modelSetter = model.assign;

			element.bind('change', function(changeEvent) {
				scope.$apply(function() {
					var reader = new FileReader();
		            reader.onload = function (loadEvent) {
		            	scope.$apply(function () {
		            		scope.questionPic = loadEvent.target.result;
		                   	var file = element[0].files[0];
		    				modelSetter(scope, file);
		                });
		            }
		            reader.readAsDataURL(changeEvent.target.files[0]);
					/* TODO : gösterilecek
					 * var blob = new Blob([file], {type:'application/octet-binary'});
					scope.uploadedPic = blob;*/
					
				});
			});
		}
	};
}]);