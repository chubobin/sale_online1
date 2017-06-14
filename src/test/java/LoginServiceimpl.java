

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chubobin.trade.bean.T_MALL_USER;
import com.chubobin.trade.mapper.LoginMapper;

@Service
public class LoginServiceimpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;
	@Override
	public T_MALL_USER confrimUser(T_MALL_USER user) {
		return loginMapper.select_loginUser(user);
	}
	
	
}
