import { Module } from '@nestjs/common';
import { GoodService } from './good.service';
import { GoodController } from './good.controller';

@Module({
  controllers: [GoodController],
  providers: [GoodService],
})
export class GoodModule {}
