package com.example.servingwebcontent.Repository;

import com.example.servingwebcontent.Model.Truongdaihoc.CoSoVatChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoSoVatChatRepository extends JpaRepository<CoSoVatChat, Integer> {
}
