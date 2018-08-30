create sequence sequencia_id_lancamento
select nextval('sequencia_id_lancamento')

create or replace function public.f_realizar_pagamento(p_pagamento numeric(10,2), p_nr_cartao integer, p_senha_cartao varchar(100))
returns character as
$$

	declare
	
	var_saldo numeric;	
	var_senha varchar(100);
	
	begin
	
	var_senha := (select senha from cartao where p_nr_cartao = idcartao);
	
	if (var_senha = p_senha_cartao) then
		
		var_saldo := (select valorsaldo from cartao where p_nr_cartao = idcartao);
		
		if (p_pagamento > var_saldo) then
			return 'Saldo disponivel insuficiente para transação';
		else
		
			insert into lancamento_cartao
			values ((select nextval('sequencia_id_lancamento')), p_pagamento, (select current_date), p_nr_cartao);
			
			update cartao
			set valorsaldo = (var_saldo - p_pagamento)
			where idcartao = p_nr_cartao;
			
		end if;
	
	else 
	
		return 'Senha Invalida!';	
		
	end if;
	
	return 'Transação realizada com exito! Consulte a tabela lancamento_cliente';
	
	end;
	
$$
language plpgsql volatile

select f_realizar_pagamento(300.50, 1, '123')
select * from cartao
select * from lancamento_cartao