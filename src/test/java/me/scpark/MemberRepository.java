package me.scpark;

import org.springframework.data.repository.Repository;

import java.lang.reflect.Member;

interface MemberRepository extends Repository<Member, Long> {
}
