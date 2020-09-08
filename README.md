# IPv4-Datagram-Analyzer-

The work consists in the development of a Java application for the analysis of fragmentation in IPv4 datagrams. The application receives two pieces of information: The size of a datagram and the MTU of the network where the datagram will be transmitted. The application must parse this input data and output a table with the following information in each row:
1. Total length of the fragment
2. Flags (3 bits)
3. Offset (binary) (13 bits)
4. Offset (decimal)
5. The four hexadecimal digits that represent the 16 bits
