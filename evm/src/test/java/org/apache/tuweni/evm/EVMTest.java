/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements. See the NOTICE
 * file distributed with this work for additional information regarding copyright ownership. The ASF licenses this file
 * to You under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.apache.tuweni.evm;

import org.apache.tuweni.eth.precompiles.Registry;
import org.apache.tuweni.eth.repository.BlockchainRepository;
import org.apache.tuweni.evm.impl.EvmVmImpl;
import org.apache.tuweni.genesis.Genesis;
import org.apache.tuweni.junit.BouncyCastleExtension;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BouncyCastleExtension.class)
public class EVMTest {

  @Test
  void testStartAndStop() {
    BlockchainRepository repository = BlockchainRepository.Companion.inMemoryBlocking(Genesis.dev());

    EthereumVirtualMachine vm = new EthereumVirtualMachine(
        repository,
        repository,
        Registry.getIstanbul(),
        EvmVmImpl::create,
        Collections.singletonMap("DISABLE_TRANSFER_VALUE", "true"));
    vm.startAsync();
    vm.stopAsync();
  }
}
