package com.example.servingwebcontent.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.servingwebcontent.Model.Truongdaihoc.CoSoVatChat.CoSoVatChat;

@Repository
public interface CoSoVatChatRepository extends JpaRepository<CoSoVatChat, Integer> {
}
