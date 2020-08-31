package cn.eskyzdt.wordgame.module.safe;

import cn.eskyzdt.wordgame.service.usr.IUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private IUserService userService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        cn.eskyzdt.wordgame.entity.usr.User user = userService.query().eq("username", username).one();
        if (user == null) {
            throw new UsernameNotFoundException("无该用户");
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
        User userDetails = new User(user.getUsername(), passwordEncoder.encode(user.getPassword()), authorities);
        return userDetails;
    }

}