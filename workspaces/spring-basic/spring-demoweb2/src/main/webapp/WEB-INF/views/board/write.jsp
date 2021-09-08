<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html lang="ko">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>DemoWeb Board</title>

    <jsp:include page="/WEB-INF/views/modules/common-css.jsp" />

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

		<jsp:include page="/WEB-INF/views/modules/sidebar.jsp" />
        
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

				<jsp:include page="/WEB-INF/views/modules/topbar.jsp" />

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">게시판</h1>
                    </div>

					<div class="card shadow mb-4">
                         <div class="card-header py-3">
                             <h6 class="m-0 font-weight-bold text-primary">글 쓰기</h6>
                         </div>
                         <div class="card-body">
                             <form id="board-write-form" action="write" method="post">
                             	<div class="form-group">
                             		<label>제목</label>
                             		<input type="text" class="form-control" name="title">
                             	</div>
                             	<div class="form-group">
                             		<label>작성자</label>
                             		<input type="text" class="form-control" name="writer">
                             	</div>
                             	<div class="form-group">
                             		<label>내용</label>
                             		<textarea class="form-control" name="content" rows="5"></textarea>
                             	</div>
                             	
                             	<button id="write-button" class="btn btn-primary btn-sm">쓰기</button>
                             	<button id="tolist-button" class="btn btn-primary btn-sm">목록</button>
                             	
                             </form>	
                         </div>
                     </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

			<%@ include file="/WEB-INF/views/modules/footer.jsp" %>

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/modules/common-js.jsp" />

	<script type="text/javascript">
	$(function() { // jQuery의 main 함수 역할 ( 시작점 )
		
		$('#write-button').on('click', function(event) {
			event.preventDefault();		// 이벤트를 발생시킨 객체의 기본 동작 ( 다른페이지로 이동 등 ) 의 수행을 차단
			event.stopPropagation();	// 상위 객체로 이벤트 전달 차단
			
			// 입력 데이터의 유효성 검사 등 처리
			
			$('#board-write-form').submit(); // form을 서버로 전송
			
		});
	
		$('#tolist-button').on('click', function(event) {
			event.preventDefault();		// 이벤트를 발생시킨 객체의 기본 동작 ( 다른페이지로 이동 등 ) 의 수행을 차단
			event.stopPropagation();	// 상위 객체로 이벤트 전달 차단
			
			location.href = "list";
			
		});
		
	});
	</script>


</body>

</html>













