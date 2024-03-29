package com.ecommerce.sprintboot.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class UserDetailsImpl extends User implements UserDetails {

    public UserDetailsImpl() {
    }

    public UserDetailsImpl(final User user) {
        super( user );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        System.out.println( getRoles());
       return getRoles()
                .stream()
                .map( role ->{
                            System.out.println( "ROLE_" +role.getDescription() );

                    return        (GrantedAuthority) new SimpleGrantedAuthority( "ROLE_" +role.getDescription());
                }

                )
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        System.out.println( "EMAIL -> " + super.getEmail());
        return super.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
