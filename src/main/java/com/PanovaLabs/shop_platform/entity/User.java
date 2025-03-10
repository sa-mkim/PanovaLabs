package com.PanovaLabs.shop_platform.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor 
@Data
@Entity
@Table(name = "TB_USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 50)
    private String username;  // 로그인 ID

    @Column(nullable = false, unique = true, length = 255)
    private String email;  // 이메일

    @Column(nullable = false, length = 255)
    private String password;  // 비밀번호 (암호화 필수!)

    @Column(name = "full_name", length = 100)
    private String fullName;  // 실명 (선택)

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;  // 전화번호 (선택)

    @Column(nullable = false, length = 20)
    private String role = "USER";  // 권한 (기본값: USER)

    @Column(nullable = false, length = 20)
    private String status = "ACTIVE";  // 계정 상태 (기본값: ACTIVE)

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;  // 계정 생성 시간

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;  // 마지막 수정 시간
	
	
	public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


	
}
