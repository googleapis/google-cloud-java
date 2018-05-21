$('.nav-current').click(function(){
    $('.main-nav').toggleClass('open');
});

$('.faq-btn').click(function(){
	$(this).toggleClass('open');
});

(function() {
  var myAppModule = angular.module('gcloud-java', []);
  hljs.initHighlightingOnLoad();
})();
