package leaf.service.jwt;

class UnauthorizedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    UnauthorizedException() {
        super("계정 권한이 유효하지 않습니다. \n다시 로그인을 해 주세요.");
    }

}
