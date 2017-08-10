;
!function() {
	layer.use('extend/layer.ext.js',
			function() {
		// 初始加载即调用，所以需放在ext回调里
		layer.ext = function() {
			layer
			.photosPage({
				html : '<div style="padding:20px;">html<p>相册支持左右方向键，支持Esc关闭</p><p>另外还可以通过异步返回json实现相册。更多用法详见官网。</p><p>'
					+ unescape("代码笔记 www.198zone.com")
					+ '</p><p id="change"></p></div>',
					id : 100, // 相册id，可选
					parent : '#imgs'
			});
		};
	});
}();