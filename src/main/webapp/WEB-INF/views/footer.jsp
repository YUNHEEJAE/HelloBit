
	<!-- jQuery 2.2.3 -->
	<script src="resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<!-- Bootstrap 3.3.6 -->
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<!-- iCheck -->
	<script src="resources/plugins/iCheck/icheck.min.js"></script>
	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
	</script>


	<div id="syno-nsc-ext-comp-1008" class=" x-tip-invalid"
		style="position: absolute; z-index: 11000; visibility: hidden; display: none;">
		<div class="x-tip-invalid-tl">
			<div class="x-tip-invalid-tr">
				<div class="x-tip-invalid-tc">
					<div class="x-tip-invalid-header x-unselectable"
						id="syno-nsc-ext-gen4">
						<span class="x-tip-invalid-header-text"></span>
					</div>
				</div>
			</div>
		</div>
		<div class="x-tip-invalid-bwrap" id="syno-nsc-ext-gen5">
			<div class="x-tip-invalid-ml">
				<div class="x-tip-invalid-mr">
					<div class="x-tip-invalid-mc" id="syno-nsc-ext-gen8">
						<div class="x-tip-invalid-body" id="syno-nsc-ext-gen6"
							style="height: auto;"></div>
					</div>
				</div>
			</div>
			<div class="x-tip-invalid-bl x-panel-nofooter" id="syno-nsc-ext-gen7">
				<div class="x-tip-invalid-br">
					<div class="x-tip-invalid-bc"></div>
				</div>
			</div>
		</div>
		<div class="x-tip-anchor x-tip-anchor-top" id="syno-nsc-ext-gen9"
			style="z-index: 11001;"></div>
	</div>
	<canvas id="__gesture_canvas__" width="0" height="0"
		style="z-index: 100000000; position: fixed; background: transparent !important; top: 0px; left: 0px;"></canvas>
	<span id="__gesture_preview__"
		style="z-index: 100000001; position: absolute; background: rgba(255, 255, 225, 0.85098); margin: 0px; border: 1px solid black; white-space: nowrap; display: none;"></span>
</body>
</html>