TrabalhoFinal
=============

Repositorio do trabalho de Grafos

Especificação:

 Trabalho Final:
	Desenvolver um sistema que encontre a rota "mais barata" entre dois pontos
Os pontos e conexões são definidos em um arquivo com o seguinte formato:
			           (1)  1.32  5.10
			Vertices :  #    X     Y
			arestas: a b custo
Onde "custo" é um valor de pedágio entre os pontos e não considera a distância.
Além de encontrar a rota com menor custo entre dois pontos, o sistema deve encontrar 
a "melhor" rota entre vários pontos (Caixeiro Viajante). 

O sistema deve ser capaz de encontrar "pontos de parada" em uma rita, dadas as restrições "tempo máximo sem paradas"
e "distância máxima sem paradas".

Caso código de outras fontes, por favor citá-las.

Restrições:
  1 de distância = 1km.
  3 Horas no máximo dirigindo.
  ônibus anda no máximo a 80km/h.
  Distância máxima de 600km

Dicas: 
calcular a distância entre dois pontos.
Criar algoritmo de caixeiro viajante.
